class AsciiDecoding {
    static final AsciiDecoding INSTANCE = new AsciiDecoding();

    static String decode(String str1, String regex) {
        if(str1 == "") return "";
        StringBuffer sbu = new StringBuffer();
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
