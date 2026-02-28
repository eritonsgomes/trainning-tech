package tech.trainning.trainningspringvalidation.errors;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class AbstractError<E> {

    protected Instant timestamp;
    protected Integer status;
    protected String error;
    protected E errors;
    protected String path;

}
