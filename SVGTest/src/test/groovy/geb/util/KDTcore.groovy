package geb.util

import static org.hamcrest.CoreMatchers.*
import static org.hamcrest.Matchers.*
import static org.junit.Assert.*
import static spock.util.matcher.HamcrestSupport.*
import geb.Browser
import geb.spock.GebSpec

class KDTcore extends GebSpec{
	static final String INPUT = "入力"
	static final String CLICK = "クリック"
	static final String SELECT = "選択"
	static final String ASSERT = "検証"
	static final String REPORT = "記録"
	static final String SLEEP = "停止"
	static final String EQUALE = "と等しい"
	static final String CONTAIN = "を含む"

	def static void kdtByExcel(url, sheet){
		Browser.drive {
			go url

			for(int i=2; sheet["A"+i].value != null; i++){
				switch(sheet["A"+i].value){
					case INPUT:
						$("#"+sheet["B"+i].value).value(sheet["C"+i].value.toString())
						break
					case CLICK:
						$("#"+sheet["B"+i].value).click()
						break
					case ASSERT:
						expect:
						try{
							switch(sheet["D"+i].value){
								case EQUALE:
									assert that($("#"+sheet["B"+i].value).text(), is(sheet["C"+i].value))
									break
								case CONTAIN:
									assert that($("#"+sheet["B"+i].value).text(), containsString(sheet["C"+i].value))
									break
							}
						}catch(AssertionError e){
							report "error"
							throw e
						}
						break
					case REPORT:
						report sheet["C"+i].value
						break
					case SLEEP:
						sleep Integer.parseInt(sheet["C"+i].value)
						break
				}
			}
		}
	}
}
