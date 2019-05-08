class EmptyCoding extends Coding{
    private EmptyCoding() {
        super("NULL", null, null);
    }

    static final EmptyCoding INSTANCE = new EmptyCoding();

}
