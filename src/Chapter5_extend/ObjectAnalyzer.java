package Chapter5_extend;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {

    private ArrayList<Object> visited = new ArrayList<>();

    /*
    * Converts an object to a String representation that lists all fields.
    * */
    public String toString(Object obj){
        if (obj == null) return "null";
        if (visited.contains(obj)) return "...";
        visited.add(obj);
        Class c1 = obj.getClass();
        if (c1 == String.class) return (String) obj;
        if (c1.isArray()){
            String r = c1.getComponentType()+"[]{";
            for (int i = 0; i< Array.getLength(obj); i++){
                if (i>0) r+=",";
                Object val = Array.get(obj,i);
                if (c1.getComponentType().isPrimitive()) r+=val;
                else r += toString(val);
            }
            return r+"}";
        }

        String r = c1.getName();
        do {
            r += "[";
            Field[] fields = c1.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            //get the names and values of all fields
            for (Field f : fields){
                if (!Modifier.isStatic(f.getModifiers())){
                    if (!r.endsWith("[")) r+=",";
                    r += f.getName() + "=";
                    try {
                        Class t = f.getType();
                        Object val = f.get(obj);
                        if (t.isPrimitive()) r += val;
                        else r += toString(val);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            c1 = c1.getSuperclass();
        }while (c1 != null);
        return r;
    }
}
