package ru.acorn.reactivespring.fluxandmonoplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

public class FluxAndMonoFilterTest {

    List<String> names = Arrays.asList("adam", "anna", "factor");

    @Test
    public void filterTest(){
        Flux<String> namesFlux = Flux.fromIterable(names)
                .filter(s -> s.startsWith("a"))
                .log();

        StepVerifier.create(namesFlux)
                .expectNext("adam", "anna")
                .verifyComplete();
    }
}
