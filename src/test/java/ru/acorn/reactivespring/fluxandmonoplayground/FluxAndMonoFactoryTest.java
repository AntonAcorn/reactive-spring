package ru.acorn.reactivespring.fluxandmonoplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class FluxAndMonoFactoryTest {

    List<String> names = Arrays.asList("adam", "anna", "factor");

    @Test
    public void fluxUsingIterable(){

        Flux<String> namesFlux = Flux.fromIterable(names)
                .log();

        StepVerifier.create(namesFlux)
                .expectNext("adam", "anna", "factor")
                .verifyComplete();
    }

    @Test
    public void fluxUsingArray(){

        String[] names = new String[]{"adam", "anna", "factor"};

        Flux<String> namesFlux = Flux.fromArray(names)
                .log();

        StepVerifier.create(namesFlux)
                .expectNext("adam", "anna", "factor")
                .verifyComplete();
    }

    @Test
    public void fluxUsingStream(){

        Flux<String> namesFlux = Flux.fromStream(names.stream())
                .log();

        StepVerifier.create(namesFlux)
                .expectNext("adam", "anna", "factor")
                .verifyComplete();
    }

    @Test
    public void monoUsingJustOrEmpty(){

        Mono<String> mono = Mono.justOrEmpty(null);

        StepVerifier.create(mono)
                .verifyComplete();
    }

    @Test
    public void monoUsingSupplier(){

        Supplier<String> stringSupplier = () -> "Adam";

        Mono<String> stringMono = Mono.fromSupplier(stringSupplier);

        System.out.println(stringSupplier.get());

        StepVerifier.create(stringMono.log())
                .expectNext("Adam")
                .verifyComplete();
    }


    @Test
    public void fluxUsingRange(){

        Flux<Integer> integerFlux = Flux.range(1, 5);

        StepVerifier.create(integerFlux)
                .expectNext(1, 2, 3, 4, 5)
                .verifyComplete();
    }
}
