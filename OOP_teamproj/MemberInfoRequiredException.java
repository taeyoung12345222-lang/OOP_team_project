public class MemberInfoRequiredException extends Exception {
    public MemberInfoRequiredException() {
        super("[오류] 회원 정보가 없습니다. 먼저 3번에서 회원 정보를 입력해주세요.");
    }
}
