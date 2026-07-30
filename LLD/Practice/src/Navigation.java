public class Navigation {
    private RouteStrategy routeStrategy;

    public Navigation(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void setStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void executeNavigation(String start, String end) {
        String result = this.routeStrategy.buildRoute(start, end);
        System.out.println(result);
    }
}
