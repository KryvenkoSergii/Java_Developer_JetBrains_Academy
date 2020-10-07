import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] url = scanner.nextLine().split("\\?");
        String[] uri = url.length > 1 ? url[1].split("&") : null;
        if (uri != null) {
            String password = "";
            for (String parameter : uri) {
                int symbEq = parameter.indexOf("=");
                System.out.println(parameter.substring(0, symbEq) + " : " +
                        (symbEq != parameter.length() - 1 ?
                                parameter.substring(symbEq + 1, parameter.length()) :
                                "not found"));
                if ("pass".equals(parameter.substring(0, symbEq))) {
                    password = "pass".equals(parameter.substring(0, symbEq)) ?
                            parameter.substring(symbEq + 1, parameter.length()) :
                            "";
                }
            }
            if (password.length() > 0) {
                System.out.println("password : " + password);
            }
        }

//        String[] split = new Scanner(System.in).nextLine()
//                .split("\\?")[1].split("&");
//        Map<String, String> map = Arrays.stream(split).map(s -> s.split("="))
//                .collect(Collectors.toMap(
//                        ar -> ar[0],
//                        ar -> ar.length == 1 ? "not found" : ar[1],
//                        (o, o2) -> o,
//                        LinkedHashMap::new));
//        if (map.containsKey("pass")) {
//            map.put("password", map.get("pass"));
//        }
//        map.forEach((key, value) -> System.out.printf("%s : %s\n", key, value));
    }
}
