package Chapter5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest {
    public static void main(String[] args) {
        String name;
        if (args.length>0) name = args[0];
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date):");
            name = in.next();
        }

        try {
            Class c1 = Class.forName(name);
            Class superc1 = c1.getSuperclass();
            String modifiers = Modifier.toString(c1.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.print("class "+name);
            if(superc1 != null && superc1 != Object.class)
                System.out.print(" extends "+superc1.getName());
            System.out.print("\n{\n");
            printConstructors(c1);
            System.out.println();
            printMethods(c1);
            System.out.println();
            printFields(c1);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void printConstructors(Class c1){
        Constructor[] constructors = c1.getConstructors();
        for (Constructor c : constructors){
            String name = c.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(c1.getModifiers());
            if (modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.print(name+"(");

            //print parameter types
            Class[] paramTypes = c.getParameterTypes();
            for(int j = 0; j<paramTypes.length; j++){
                if(j>0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /*
     * Prints all methods of a class
     * @param c1 a class
     * */
    public static void printMethods(Class c1){
        Method[] methods = c1.getDeclaredMethods();
        for (Method m : methods){
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("    ");
            String modifies = Modifier.toString(m.getModifiers());
            if (modifies.length()>0) System.out.print(modifies+" ");
            System.out.print(retType.getName()+" "+name+"(");

            Class[] paramTypes = m.getParameterTypes();
            for (int j=0; j<paramTypes.length; j++){
                if(j>0) System.out.print(",");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class c1){
        Field[] fields = c1.getFields();
        for (Field f : fields){
            Class type = f.getType();
            String name = f.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.println(type.getName()+" "+name+";");
        }
    }
}
