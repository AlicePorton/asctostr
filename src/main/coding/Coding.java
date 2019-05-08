abstract class Coding {
    private String key;
    private String initVector;
    private final String name;

    final String name() {
        return name;
    }

    Coding(String canonicalName, String key, String initVector) {
        this.key = key;
        this.initVector = initVector;
        this.name = canonicalName;
    }


    byte[] encrypt(String key, String initVector, byte[] value) {
       return value;
    }
    byte[] decrypt(String key, String initVector, byte[] value) {
       return value;
    }
    byte[] encrypt(byte[] value) {
        return this.encrypt(key, initVector, value);
    }
    byte[] decrypt(byte[] value) {
        return this.decrypt(key, initVector, value);
    }

    public final String toString() {
        return name();
    }

}