package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Boolean isRetryGame = false;

    private final List<String> bridge;

    private final BridgePlayer bridgePlayer;

    public BridgeGame(List<String> bridge, BridgePlayer bridgePlayer) {
        this.bridge = bridge;
        this.bridgePlayer = bridgePlayer;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        bridgePlayer.checkMove(bridge);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgePlayer.addTryCount();
        this.isRetryGame = true;
    }

    public boolean getRetryStatus() {
        return isRetryGame;
    }

    public boolean isNotGameEnd() {
        return bridgePlayer.getCurrentBridgeSpace() < bridge.size();
    }

    public void checkRetryGameResult(boolean isSuccess) {
        if (isSuccess && isRetryGame) {
            isRetryGame = false;
        }
    }
}
