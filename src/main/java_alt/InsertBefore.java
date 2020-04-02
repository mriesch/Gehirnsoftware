import javassist.ClassPool;
import javassist.NotFoundException;
import javassist.*;

import java.io.IOException;

public class InsertBefore {

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("Point");
        CtMethod m = cc.getDeclaredMethod("move");
        m.insertBefore("{ System.out.println($1); System.out.println($2); }");
        cc.writeFile("bla");
    }

}
