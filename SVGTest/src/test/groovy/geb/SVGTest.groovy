package geb

import geb.util.*

import org.jggug.kobo.gexcelapi.GExcel
import org.junit.After
import org.junit.Before
import org.junit.Test

class SVGTest {

	def file = "src/test/resources/kdt.xlsx"
	def url = "file:///D:/work/ITDashboard/html/1211.html"
	def book



	@Before
	void setUp() {
		book = GExcel.open(file)
	}

	@After
	void tearDown() {
		book = null
	}

	@Test
	def void "SVGのテスト"(){
		KDTcore.kdtByExcel(url, book[0])
	}
}

