public class Player
{
    private static final int MINIMUM_SCORE_DIFF_TO_WIN = 2;
    private static final int DEUCE = 4;

    private final String name;
    private int score;

    public Player(final String name)
    {
        this.name = name;
        this.score = 0;
    }

    public String name()
    {
        return name;
    }

    public int score()
    {
        return score;
    }

    public void incrementScore()
    {
        score++;
    }

    public boolean hasAdvantage(final Player otherPlayer)
    {
        return score >= DEUCE && scoreDiff(otherPlayer) == 1;
    }

    public boolean hasWon(final Player otherPlayer)
    {
        return score >= DEUCE && scoreDiff(otherPlayer) >= MINIMUM_SCORE_DIFF_TO_WIN;
    }

    private int scoreDiff(final Player otherPlayer)
    {
        return score - otherPlayer.score;
    }
}
