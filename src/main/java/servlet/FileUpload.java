package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

import Infomations.InfoClass;
import Infomations.ReadExcel;
import net.sf.json.JSONArray;
import org.apache.commons.fileupload.FileItem;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Created by ZhiLI on 2016/3/10.
 */
public class FileUpload extends HttpServlet {
    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 50 * 1024;
    private File file;

    public void init() {
        filePath = getServletContext().getInitParameter("file-upload");
        System.out.println(filePath);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        java.io.PrintWriter out = response.getWriter();
        if ( !isMultipart) {
            out.println("<html>");
             out.println("<body>");
                out.println("<p>");
                    out.println("no file uploaded");
                out.println("</p>");
             out.println("</body>");
            out.println("</html>");
        }

        System.out.println("yoooooooooooooo");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(maxFileSize);

        factory.setRepository(new File("c:\\temp"));

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(maxFileSize);

        try {
            List fileItems = upload.parseRequest(request);
            Iterator i = fileItems.iterator();

            while (i.hasNext()) {
                FileItem fi = (FileItem)i.next();
                String fileName = fi.getName();
                String contentType = fi.getContentType();
                boolean isInmemory = fi.isInMemory();

                System.out.println("hppppppp");
                System.out.println(fileName);
                if (fileName.lastIndexOf("\\") >=0 ) {
                    System.out.println(1111);
                    file = new File (filePath +fileName.substring(fileName.lastIndexOf("\\")));
                }
                else  {
                    System.out.println(2222);
                    String uploadFilePath = filePath +fileName.substring(fileName.lastIndexOf("\\")+1);
                    System.out.println(uploadFilePath);

                    file = new File (uploadFilePath);
                    if (file.exists()) {
                        file.delete();
                    }
                }
                fi.write(file);
                System.out.println(file.getAbsolutePath());
            }

        } catch (Exception ex) {
            System.out.println("error in fileUpload");
        }

        try {
            ReadExcel excel = new ReadExcel(this.file.getAbsolutePath());
            Set<InfoClass> infoGradeSet = new HashSet<InfoClass>();
            infoGradeSet = excel.getInfoGrade();
            System.out.println(infoGradeSet);
            JSONArray jsonArray = new JSONArray();
            jsonArray = JSONArray.fromObject(infoGradeSet.toArray());

            System.out.println(jsonArray);
            out.print(jsonArray);
            out.flush();
            out.close();
//            ConvertJSON convertJSON = new ConvertJSON();
//            infoGradeJsonArr = convertJSON.set2json(infoGradeSet);
//            System.out.println(infoGradeJsonArr);
        } catch (Exception ex) {
            System.out.println("error in parse Excel");
        }
    }
}
