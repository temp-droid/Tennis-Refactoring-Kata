public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name)
    {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore()
    {
        if (P1point == P2point)
        {
            switch (P1point)
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
            }
        }

        if (P1point >= 4)
        {
            if (P1point - P2point == 1)
                return "Advantage player1";
            if (P1point - P2point >= 2)
                return "Win for player1";
        }

        if (P2point >= 4)
        {
            if (P2point - P1point == 1)
                return "Advantage player2";
            if (P2point - P1point >= 2)
                return "Win for player2";
        }

        String p1 = getP1Point();
        String p2 = getP2Point();

        return p1 + "-" + p2;
    }

    private String getP1Point()
    {
        return getPoint(P1point);
    }

    private String getP2Point()
    {
        return getPoint(P2point);
    }

    private String getPoint(final int p1point)
    {
        if (p1point == 0)
            return "Love";
        if (p1point == 1)
            return "Fifteen";
        if (p1point == 2)
            return "Thirty";
        if (p1point == 3)
            return "Forty";
        return null;
    }

    public void P1Score()
    {
        P1point++;
    }

    public void P2Score()
    {
        P2point++;
    }

    public void wonPoint(String player)
    {
        if (player.equals("player1"))
            P1Score();
        else
            P2Score();
    }
}