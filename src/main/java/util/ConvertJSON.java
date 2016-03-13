package util;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ConvertJSON {

    /**
     * 对象转换为Json
     * @param obj
     * @return
     */
    public static String object2json(Object obj) {
        StringBuilder json = new StringBuilder();
        if (obj == null) {
            json.append("\"\"");
        } else if (obj instanceof String || obj instanceof Integer
                || obj instanceof Float || obj instanceof Boolean
                || obj instanceof Short || obj instanceof Double
                || obj instanceof Long || obj instanceof BigDecimal
                || obj instanceof BigInteger || obj instanceof Byte) {
            json.append("\"").append(string2json(obj.toString())).append("\"");
        } else if (obj instanceof Object[]) {
            json.append(array2json((Object[]) obj));
        } else if (obj instanceof List) {
            json.append(list2json((List<?>) obj));
        } else if (obj instanceof Map) {
            json.append(map2json((Map<?, ?>) obj));
        } else if (obj instanceof Set) {
            json.append(set2json((Set<?>) obj));
        } else {
            json.append(bean2json(obj));
        }
        return json.toString();
    }

    /**
     * 对象bean转换为Json
     * @param bean
     * @return
     */
    public static String bean2json(Object bean) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        PropertyDescriptor[] props = null;
        try {
            props = Introspector.getBeanInfo(bean.getClass(), Object.class)
                    .getPropertyDescriptors();
        } catch (IntrospectionException e) {
        }
        if (props != null) {
            for (int i = 0; i < props.length; i++) {
                try {
                    String name = object2json(props[i].getName());
                    String value = object2json(props[i].getReadMethod().invoke(
                            bean));
                    json.append(name);
                    json.append(":");
                    json.append(value);
                    json.append(",");
                } catch (Exception e) {
                }
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        return json.toString();
    }

    /**
     * List集合转换为Json
     * @param list
     * @return
     */
    public static String list2json(List<?> list) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
                json.append(object2json(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
    }

    /**
     * 对象数组转换为Json
     * @param array
     * @return
     */
    public static String array2json(Object[] array) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (array != null && array.length > 0) {
            for (Object obj : array) {
                json.append(object2json(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
    }

    /**
     * Map集合转换为Json
     * @param map
     * @return
     */
    public static String map2json(Map<?, ?> map) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        if (map != null && map.size() > 0) {
            for (Object key : map.keySet()) {
                json.append(object2json(key));
                json.append(":");
                json.append(object2json(map.get(key)));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        return json.toString();
    }

    /**
     * Set集合转为Json
     * @param set
     * @return
     */
    public static String set2json(Set<?> set) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (set != null && set.size() > 0) {
            for (Object obj : set) {
                json.append(object2json(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
    }

    /**
     * 字符串转换为Json
     * @param s
     * @return
     */
    public static String string2json(String s) {
        if (s == null)
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '/':
                    sb.append("\\/");
                    break;
                default:
                    if (ch >= '\u0000' && ch <= '\u001F') {
                        String ss = Integer.toHexString(ch);
                        sb.append("\\u");
                        for (int k = 0; k < 4 - ss.length(); k++) {
                            sb.append('0');
                        }
                        sb.append(ss.toUpperCase());
                    } else {
                        sb.append(ch);
                    }
            }
        }
        return sb.toString();
    }
}
////    /**
////     * JAVA对象转换成JSON字符串
////     * @param obj
////     * @return
////     * @throws MapperException
////     */
////    public static String objectToJsonStr(Object obj) throws MapperException{
////        JSONValue jsonValue = JSONMapper.toJSON(obj);
////        String jsonStr = jsonValue.render(false);
////        return jsonStr;
////    }
//
////    /**
////     * 重载objectToJsonStr方法
////     * @param obj 需要转换的JAVA对象
////     * @param format 是否格式化
////     * @return
////     * @throws MapperException
////     */
////    public static String objectToJsonStr(Object obj,boolean format) throws MapperException{
////        JSONValue jsonValue = JSONMapper.toJSON(obj);
////        String jsonStr = jsonValue.render(format);
////        return jsonStr;
////    }
//
//    /**
//     * JSON字符串转换成JAVA对象
//     * @param jsonStr
//     * @param cla
//     * @return
//     * @throws MapperException
//     * @throws TokenStreamException
//     * @throws RecognitionException
//     */
////    @SuppressWarnings({ "rawtypes", "unchecked" })
////    public static Object jsonStrToObject(String jsonStr,Class<?> cla) throws MapperException, TokenStreamException, RecognitionException{
////        Object obj = null;
////        try{
////            JSONParser parser = new JSONParser(new StringReader(jsonStr));
////            JSONValue jsonValue = parser.nextValue();
////            if(jsonValue instanceof com.sdicons.json.model.JSONArray){
////                List list = new ArrayList();
////                JSONArray jsonArray = (JSONArray) jsonValue;
////                for(int i=0;i<jsonArray.size();i++){
////                    JSONValue jsonObj = jsonArray.get(i);
////                    Object javaObj = JSONMapper.toJava(jsonObj,cla);
////                    list.add(javaObj);
////                }
////                obj = list;
////            }else if(jsonValue instanceof com.sdicons.json.model.JSONObject){
////                obj = JSONMapper.toJava(jsonValue,cla);
////            }else{
////                obj = jsonValue;
////            }
////        }catch(Exception e){
////            e.printStackTrace();
////        }
////        return obj;
////    }
//
//    /**
//     * 将JAVA对象转换成JSON字符串
//     * @param obj
//     * @return
//     * @throws IllegalArgumentException
//     * @throws IllegalAccessException
//     */
//    @SuppressWarnings("rawtypes")
//    public static String simpleObjectToJsonStr(Object obj,List<Class> claList) throws IllegalArgumentException, IllegalAccessException{
//        if(obj==null){
//            return "null";
//        }
//        String jsonStr = "{";
//        Class<?> cla = obj.getClass();
//        Field fields[] = cla.getDeclaredFields();
//        for (Field field : fields) {
//            field.setAccessible(true);
//            if(field.getType() == long.class){
//                jsonStr += "\""+field.getName()+"\":"+field.getLong(obj)+",";
//            }else if(field.getType() == double.class){
//                jsonStr += "\""+field.getName()+"\":"+field.getDouble(obj)+",";
//            }else if(field.getType() == float.class){
//                jsonStr += "\""+field.getName()+"\":"+field.getFloat(obj)+",";
//            }else if(field.getType() == int.class){
//                jsonStr += "\""+field.getName()+"\":"+field.getInt(obj)+",";
//            }else if(field.getType() == boolean.class){
//                jsonStr += "\""+field.getName()+"\":"+field.getBoolean(obj)+",";
//            }else if(field.getType() == Integer.class||field.getType() == Boolean.class
//                    ||field.getType() == Double.class||field.getType() == Float.class
//                    ||field.getType() == Long.class){
//                jsonStr += "\""+field.getName()+"\":"+field.get(obj)+",";
//            }else if(field.getType() == String.class){
//                jsonStr += "\""+field.getName()+"\":\""+field.get(obj)+"\",";
//            }else if(field.getType() == List.class){
//                String value = simpleListToJsonStr((List<?>)field.get(obj),claList);
//                jsonStr += "\""+field.getName()+"\":"+value+",";
//            }else{
//                if(claList!=null&&claList.size()!=0&&claList.contains(field.getType())){
//                    String value = simpleObjectToJsonStr(field.get(obj),claList);
//                    jsonStr += "\""+field.getName()+"\":"+value+",";
//                }else{
//                    jsonStr += "\""+field.getName()+"\":null,";
//                }
//            }
//        }
//        jsonStr = jsonStr.substring(0,jsonStr.length()-1);
//        jsonStr += "}";
//        return jsonStr;
//    }
//
//    /**
//     * 将JAVA的LIST转换成JSON字符串
//     * @param list
//     * @return
//     * @throws IllegalArgumentException
//     * @throws IllegalAccessException
//     */
//    @SuppressWarnings("rawtypes")
//    public static String simpleListToJsonStr(List<?> list,List<Class> claList) throws IllegalArgumentException, IllegalAccessException{
//        if(list==null||list.size()==0){
//            return "[]";
//        }
//        String jsonStr = "[";
//        for (Object object : list) {
//            jsonStr += simpleObjectToJsonStr(object,claList)+",";
//        }
//        jsonStr = jsonStr.substring(0,jsonStr.length()-1);
//        jsonStr += "]";
//        return jsonStr;
//    }
//
//    /**
//     * 将JAVA的MAP转换成JSON字符串，
//     * 只转换第一层数据
//     * @param map
//     * @return
//     */
//    public static String simpleMapToJsonStr(Map<?,?> map){
//        if(map==null||map.isEmpty()){
//            return "null";
//        }
//        String jsonStr = "{";
//        Set<?> keySet = map.keySet();
//        for (Object key : keySet) {
//            jsonStr += "\""+key+"\":\""+map.get(key)+"\",";
//        }
//        jsonStr = jsonStr.substring(0,jsonStr.length()-1);
//        jsonStr += "}";
//        return jsonStr;
//    }
