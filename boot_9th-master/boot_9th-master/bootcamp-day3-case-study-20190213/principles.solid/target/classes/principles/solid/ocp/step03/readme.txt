step01
	- srp step08
step02
	- 처리흐름을 추상화시키고 SimpleTradeProcessor가 구체적인 내용을 처리하도록 변경
	- 변경에는 폐쇄되었고 확장에는 오픈되었다.
 step03
 	- 새로운 TradeProcessor의 확장으로 인해 기존 코드의 변경을 유발하지 않는다.
