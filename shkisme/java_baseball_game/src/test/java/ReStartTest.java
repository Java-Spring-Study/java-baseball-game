
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReStartTest {

  @Test
  public void restartTest() {
    Assertions.assertThat(1).isEqualTo(RestartStatus.RESTART.getRestartStatus());
    Assertions.assertThat(2).isEqualTo(RestartStatus.END.getRestartStatus());
  }
}
