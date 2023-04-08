package com.adamjurcz.personaltrainerapp.core.usecases;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public interface UseCaseExecutor {
    <AX, I extends UseCase.Input, O extends UseCase.Output> CompletableFuture<AX> execute(
            UseCase<I, O> useCase,
            I input,
            Function<O, AX> mapper
    );
}
