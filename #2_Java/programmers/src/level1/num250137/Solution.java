package level1.num250137;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int[] bandage, int health, int[][] attacks) {
		
		// 현재 체력과 현재 시간을 저장할 각 변수 초기화
		int curHealth = health;
		int curTime = 0;
		
		// for 반복문을 사용해 몬스터의 각 공격을 순회
		for (int[] attack : attacks) {
			
			// 몬스터의 공격 시간과 피해량을 각 변수에 할당
			int attackTime = attack[0];
			int damage = attack[1];
			
			// min() 메서드를 사용해 현재 시간과 몬스터의 공격 시간 사이의 시간 동안 체력 회복
			curHealth = Math.min(curHealth + (attackTime - curTime - 1) * bandage[1], health);
			
			// 연속 회복에 성공한 경우 추가 회복량만큼의 체력 회복
			if (attackTime - curTime >= bandage[0])
				curHealth = Math.min(curHealth + (attackTime - curTime - 1) / bandage[0] * bandage[2], health);
			
			// 몬스터의 피해를 입은 것으로 처리
			curHealth -= damage;
			
			// 캐릭터의 체력이 0 이하가 된 경우 -1 반환
			if (curHealth <= 0)
				return -1;
			
			// 현재 시간을 갱신
			curTime = attackTime;
		}
		
		// 모든 공격이 끝난 직후 남은 체력을 반환
		return curHealth;
    }
}