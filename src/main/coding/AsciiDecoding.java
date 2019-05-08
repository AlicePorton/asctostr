
class AsciiDecoding extends Coding {
    private AsciiDecoding(String key, String initVector) {
        super("ASCII", key, initVector);
    }

    static final AsciiDecoding INSTANCE = new AsciiDecoding(null, null);

    @Override
    byte[] encrypt(byte[] value) {
        StringBuilder sb = new StringBuilder();
        for(byte t : value) {
            int i = (int)t;
            String hex_i = Integer.toHexString(i);

            sb.append(hex_i);
        }
        return sb.toString().getBytes();
    }

    // FIXME: Read a int as char is memory waste
    byte[] decrypt(byte[] value){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < value.length; i = i+2) {
            String s = "" + (char)value[i] + (char)value[i+1];
            int t = Integer.parseInt(s, 16);
            sb.append((char)t);
        }

        String str = sb.toString();
        return str.getBytes();
    }
}
