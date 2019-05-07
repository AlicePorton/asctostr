class AsciiDecoding {
    static final AsciiDecoding INSTANCE = new AsciiDecoding();

    static String decode(String str1, String regex) {
        if(str1.equals("")) return "";
        StringBuilder sbu = new StringBuilder();
        String[] chars = str1.split(regex);
        for (String aChar : chars) {
            sbu.append((char) Integer.parseInt(aChar));
        }
        return sbu.toString();
    }

    static String decode(String str1){
        return decode(str1, ";");
    }
}
