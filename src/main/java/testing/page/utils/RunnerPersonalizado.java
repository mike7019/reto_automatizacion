package testing.page.utils;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class RunnerPersonalizado extends Runner {
    private Class<CucumberWithSerenity> classValue;
    private CucumberWithSerenity cucumberWithSerenity;

    public RunnerPersonalizado(Class<CucumberWithSerenity> classValue) throws Exception {
        this.classValue = classValue;
        this.cucumberWithSerenity = new CucumberWithSerenity(classValue);
    }

    public Description getDescription() {
        return this.cucumberWithSerenity.getDescription();
    }

    private void runAnnotatedMethods(Class<?> annotation) throws Exception {
        if (annotation.isAnnotation()) {
            Method[] methods = this.classValue.getMethods();
            Method[] var3 = methods;
            int var4 = methods.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Method method = var3[var5];
                Annotation[] annotations = method.getAnnotations();
                Annotation[] var8 = annotations;
                int var9 = annotations.length;

                for(int var10 = 0; var10 < var9; ++var10) {
                    Annotation item = var8[var10];
                    if (item.annotationType().equals(annotation)) {
                        method.invoke((Object)null);
                        break;
                    }
                }
            }

        }
    }

    public void run(RunNotifier notifier) {
        try {
            this.runAnnotatedMethods(BeforeSuite.class);
            this.cucumberWithSerenity = new CucumberWithSerenity(this.classValue);
        } catch (Exception var3) {
            Logger.getLogger("context", String.valueOf(var3));
        }

        this.cucumberWithSerenity.run(notifier);
    }
}
