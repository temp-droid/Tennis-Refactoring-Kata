import java.util.Optional;

public class TennisGame2 implements TennisGame
{
    private final Player player1;
    private final Player player2;

    public TennisGame2(String player1Name, String player2Name)
    {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public String getScore()
    {
        if (player1.score() == player2.score())
            return handleEquality();

        Optional<Player> playerInAdvantage = playerInAdvantage();
        if (playerInAdvantage.isPresent())
            return "Advantage " + playerInAdvantage.get().name();

        Optional<Player> winner = winner();
        if (winner.isPresent())
            return "Win for " + winner.get().name();

        return defaultScoreFormat();
    }

    private Optional<Player> winner()
    {
        if (player1.hasWon(player2))
            return Optional.of(player1);
        if (player2.hasWon(player1))
            return Optional.of(player2);
        return Optional.empty();
    }

    private Optional<Player> playerInAdvantage()
    {
        if (player1.hasAdvantage(player2))
            return Optional.of(player1);
        if (player2.hasAdvantage(player1))
            return Optional.of(player2);
        return Optional.empty();
    }

    private String handleEquality()
    {
        switch (player1.score())
        {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
            case 4:
                return "Deuce";
            default:
                throw new IllegalArgumentException("Unhandled equality score " + player1.score());
        }
    }

    private String defaultScoreFormat()
    {
        return convert(player1.score()) + "-" + convert(player2.score());
    }

    private String convert(final int point)
    {
        switch (point)
        {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                throw new IllegalArgumentException("Cannot convert that point to string");
        }
    }

    public void player1Scores()
    {
        player1.incrementScore();
    }

    public void player2Scores()
    {
        player2.incrementScore();
    }

    public void wonPoint(String player)
    {
        if (player.equals("player1"))
            player1Scores();
        else
            player2Scores();
    }
}