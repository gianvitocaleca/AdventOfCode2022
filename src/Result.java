public enum Result {
    WIN(6), DRAW(3), LOSS(0);
    int points;

    Result(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
