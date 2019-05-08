
public final class StandardCoding {
    private StandardCoding() {
        throw new AssertionError("No StandardCoding");
    }

    static final Coding AES = AESCoding.INSTANCE;
    static final Coding ASCII = AsciiDecoding.INSTANCE;
    static final Coding Empty = EmptyCoding.INSTANCE;

}
