public class Main {
    public static void main(String[] args) {
        String a = "a";
        String ch = "中";

        String html = """
            @Data
            public class CommonResponse {
                /**
                 * 返回业务码用来判断成功失败
                 * 200 成功
                 * 500 失败
                 */
                private String code;
                            
                /** 描述 */
                private String massage;
                            
                /** 描述 */
                private Object date;
                            
                public CommonResponse(String code, String massage, Object date) {
                    this.code = code;
                    this.massage = massage;
                    this.date = date;
                }
                            
                public static CommonResponse succeed(){
                    return getCommonResponse(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMassage(), null);
                }
                public static CommonResponse succeed(Object date){
                    return getCommonResponse(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMassage(), date);
                }
                public static CommonResponse succeed(String massage,Object date){
                    return getCommonResponse(CodeEnum.SUCCESS.getCode(), massage, date);
                }
                            
                public static CommonResponse error(String massage){
                    return getCommonResponse(CodeEnum.ERROR.getCode(), massage, null);
                }
                public static CommonResponse error(String code,String massage){
                    return getCommonResponse(code, massage, null);
                }
                public static CommonResponse error(){
                    return getCommonResponse(CodeEnum.ERROR.getCode(), CodeEnum.ERROR.getMassage(), null);
                }
                            
                public static CommonResponse getCommonResponse(String code, String massage, Object date){
                    return new CommonResponse(code,massage,date);
                }
            }
        """;
    }
}
