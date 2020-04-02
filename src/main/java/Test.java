import java.io.*;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.util.HotSwapper;

public class Test {
// <jvmarg line="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000" />
    public static void main(String[] args) throws Exception {

        HotSwapper hs = new HotSwapper(7896);

        // Run Hello Word.
        HelloWorld h = new HelloWorld();
        h.print();

        // Create new Hello Word base on Hello Word.
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("HelloWorld");
        CtMethod m = cc.getDeclaredMethod("print");
        m.insertBefore("{ System.out.println(123123);  System.out.println(\"Matthias\"); }");
        //m.insertBefore("{ System.out.println($1); System.out.println($2); }");
        cc.writeFile("bla");

        // Load new file.
        File newfile = new File("bla\\HelloWorld.class");
        byte[] bytes = new byte[(int)newfile.length()];
        FileInputStream fileInputStream = new FileInputStream(newfile);
        int i = fileInputStream.read(bytes);
        System.out.println("** reload new Hello Word version with " +  i + " bytes");

        hs.reload("HelloWorld", bytes);

        // Exec
        new HelloWorld().print();

        newfile = new File("build\\classes\\java\\main\\HelloWorld.class");
        bytes = new byte[(int)newfile.length()];
        new FileInputStream(newfile).read(bytes);
        System.out.println("** reload the original version");

        hs.reload("HelloWorld", bytes);
        new HelloWorld().print();
    }
}
