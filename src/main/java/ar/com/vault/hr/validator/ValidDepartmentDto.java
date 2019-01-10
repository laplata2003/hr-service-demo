package ar.com.vault.hr.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { DepartmentValidator.class })
public @interface ValidDepartmentDto {

    String message() default "Departamento no permitido.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
