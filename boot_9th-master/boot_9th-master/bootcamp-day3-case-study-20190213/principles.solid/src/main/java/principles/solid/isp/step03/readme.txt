step01
	- dip step03
step02
	- 변환결과 조회하는 클라이언트를 위하여 TradeStore에 findTrades 메소드를 추가한다. 
step03
	- Store에 조회 오퍼레이션을 추가한다면 변환결과를 읽기만 하는 목적의 클라이언트는 불필요한 saveTrades도 알아야한다.
	- TradeStore를 인터페이스로 추상화하고 TradeFileStore가 TradeStore와 TreadeReadOnlyStore를 구현하도록 한다.