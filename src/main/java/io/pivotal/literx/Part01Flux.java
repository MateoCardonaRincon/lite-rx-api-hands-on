package io.pivotal.literx;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

/**
 * Learn how to create Flux instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html">Flux Javadoc</a>
 */
public class Part01Flux {

//========================================================================================

    // TODO Return an empty Flux
    Flux<String> emptyFlux() {
        return Flux.empty();
    }

//========================================================================================

    // TODO Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
    Flux<String> fooBarFluxFromValues() {
        // Concatenating two Mono generates a Flux, then it is also correct to return:
        // return Mono.just("foo").concatWith(Mono.just("bar"));
        return Flux.just("foo").concatWith(Flux.just("bar"));
    }

//========================================================================================

    // TODO Create a Flux from a List that contains 2 values "foo" and "bar"
    Flux<String> fooBarFluxFromList() {
        return Flux.fromIterable(List.of("foo", "bar"));
    }

//========================================================================================

    // TODO Create a Flux that emits an IllegalStateException
    Flux<String> errorFlux() {
        return Flux.error(IllegalStateException::new);
    }

//========================================================================================

    // TODO Create a Flux that emits increasing values from 0 to 9 each 100ms
    Flux<Long> counter() {
        // Another not so refined way of doing it
        /*return Flux.range(0, 10)
                .map(value -> value.longValue())
                .delayElements(Duration.ofMillis(100));*/
        return Flux.interval(Duration.ofMillis(1)).take(10);
    }

}
