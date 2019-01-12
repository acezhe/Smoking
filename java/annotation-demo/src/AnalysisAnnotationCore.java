import annotation.Author;
import annotation.Description;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnalysisAnnotationCore {
    public static void main(String[] args) {

        try {
            Class<UseAnnotation> target_class = (Class<UseAnnotation>) Class.forName("UseAnnotation");
            if (target_class != null) {
                Method printMethod = target_class.getMethod("printText");
                System.out.println("我们先执行下反射类的方法:");
                printMethod.invoke(target_class.getConstructor().newInstance());

                printAnnotationInfo(target_class);

                System.out.println("方法的注解信息：");

                printAnnotationInfo(printMethod);

                Field field = target_class.getDeclaredField("text");
                System.out.println("成员变量 text 注解信息：");
                printAnnotationInfo(field);
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
        }


    }

    private static void printAnnotationInfo(AnnotatedElement target) {

        if (target.isAnnotationPresent(Author.class)) {
            Author author = target.getAnnotation(Author.class);
            System.out.println("Author 信息：\n name-->" + author.name() + "\n email-->" + author.email() + "\n phone-->" + author.phone() + "\n group-->" + author.group());
        }
        if (target.isAnnotationPresent(Description.class)) {
            Description description = target.getAnnotation(Description.class);
            System.out.println("Description 信息：\n" + description.value() + "\n\n");
        }
    }

}
