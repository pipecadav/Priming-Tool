package primingtool.data;

public interface Operation<I, O> {

    O apply(I input);

}