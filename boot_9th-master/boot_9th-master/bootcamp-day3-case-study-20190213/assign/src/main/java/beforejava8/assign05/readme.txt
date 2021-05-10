step01
	- 하드코딩된 필터
step02
	- 연령/성별/연락처등록여부 필터를 인터페이스로 추상화
step03
	- 정렬을 위한 SortRule을 만들기 위해 Rule을 FilterRule로 리팩토링
step04
	- 정렬을 위한 SortRule 인터페이스 추가
	- 각 Rule에 SortRule 구현을 추가
step05
	- 배정회차를 AssignBundle 클래스로 표현
	- AssignBundle에서 고객을 배정후보(candidate)로 표현
	- 필터/정렬된 고객을 상담사에게 배정