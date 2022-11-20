package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> user;
    private final List<String> bridge;
    private final InputView inputView;

    public BridgeGame(BridgeMaker bridgeMaker) {
        this.user = new ArrayList<>();
        this.bridge = createBridge(bridgeMaker);
        this.inputView = new InputView();
    }

    public List<String> createBridge(BridgeMaker bridgeMaker){
        try {
            int bridgeSize = inputView.readBridgeSize();
            return bridgeMaker.makeBridge(bridgeSize);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return createBridge(bridgeMaker);
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = inputView.readMoving();
        user.add(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
