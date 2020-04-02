import javassist.CannotCompileException;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.NotFoundException;
import javassist.bytecode.*;

import java.util.LinkedList;
import java.util.List;


public class Demo2 {


    public static void main(String[] args) throws CannotCompileException, BadBytecode, NotFoundException {

        System.out.println("Start");
        ClassPool cp = ClassPool.getDefault();
        ClassFile cf = cp.get("Point")
                .getClassFile();
        MethodInfo minfo = cf.getMethod("move");
        CodeAttribute ca = minfo.getCodeAttribute();
        CodeIterator ci = ca.iterator();
        System.out.println("2");
        List<String> operations = new LinkedList<>();
        while (ci.hasNext()) {
            int index = ci.next();
            int op = ci.byteAt(index);
            operations.add(Mnemonic.OPCODE[op]);
            System.out.println(Mnemonic.OPCODE[op]);
        }


    }
}
