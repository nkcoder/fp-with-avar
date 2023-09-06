package my.playground.value.validation;

import io.vavr.collection.Seq;
import io.vavr.control.Validation;

public record Account(String name, Integer age, Double amount) {

}
