public class FastestRoute implements RouteStrategy {
    @Override
    public String buildRoute(String start, String end) {
        return "Taking the highway from "+start+" "+end+" . Time: 20 mins.";
    }
}
