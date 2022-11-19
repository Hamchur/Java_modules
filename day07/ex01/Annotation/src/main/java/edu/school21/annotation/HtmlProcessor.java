package edu.school21.annotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes("edu.school21.annotation.HtmlForm")
@AutoService(Processor.class)
public class HtmlProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> annotatedHtmlFormElements = roundEnv.getElementsAnnotatedWith(HtmlForm);
        for(Element annotatedHtmlFormElement : annotatedHtmlFormElements){
            printFrom(annotatedHtmlFormElement);
        }
        return false;
    }
}
