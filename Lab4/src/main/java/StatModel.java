import java.util.Map;

public class StatModel {
    Map getStat(Vlog vlog)
    {
        return Map.of("Most disliked videos", vlog.getWorstVideos().stream().map(Video::getName).toArray(), "Views on vlog",  new long[] {vlog.overallViews()});
    }
}
