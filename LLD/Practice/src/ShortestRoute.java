public class ShortestRoute implements RouteStrategy {
    @Override
    public String buildRoute(String start, String end) {
        return "Taking local backstreets from " + start + " to " + end + ". Distance: 5 km.";
    }
}
