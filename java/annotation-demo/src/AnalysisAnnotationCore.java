import annotation.Author;
import annotation.CompositeAnnotation;
import annotation.Description;
import annotation.Descriptions;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnalysisAnnotationCore {
    public static void main(String[] args) {

        try {
            Class<?> target_class = Class.forName("UseAnnotation");
            if (target_class != null) {
                Method printMethod = target_class.getMethod("printText");
                System.out.println("我们先执行下反射类的方法:");
                printMethod.invoke(target_class.getConstructor().newInstance());

                // 测试在类上使用 @Author 和 @Description
                printAnnotationInfo(target_class);

                // 测试在方法上使用 @Author 和 @Description
                System.out.println("方法的注解信息：");
                printAnnotationInfo(printMethod);

                // 测试在成员变量上使用 @CompositeAnnotation
                Field field = target_class.getDeclaredField("text");
                System.out.println("成员变量 text 注解信息：");
                printAnnotationInfo(field);
            }

            // 测试注解的继承
            System.out.println("子类上的注解信息：");
            Class<?> childClazz = Class.forName("ChildClass");
            printAnnotationInfo(childClazz);
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
        // 解析组合注解
        if (target.isAnnotationPresent(CompositeAnnotation.class)) {
            CompositeAnnotation compositeAnnotation = target.getAnnotation(CompositeAnnotation.class);
            Class<? extends Annotation> pc = compositeAnnotation.annotationType();
            printAnnotationInfo(pc);
        }

        // 解析重复注解
        if (target.isAnnotationPresent(Descriptions.class)) {
            Descriptions descriptions = target.getAnnotation(Descriptions.class);
            System.out.println("Descriptions 信息：");
            for (Description d : descriptions.value()) {
                System.out.println("\n" + d.value() + "\n\n");

            }
        }
    }

}
