
import org.scalatest.FunSuite
import com.holdenkarau.spark.testing.{SharedSparkContext, DatasetGenerator}
import org.scalatest.prop.Checkers
import org.scalacheck.{Gen, Arbitrary}
import org.scalacheck.Prop.forAll
import org.apache.spark.sql.{Dataset, SQLContext}

class FirstTest extends FunSuite with SharedSparkContext with Checkers {

  test("test initializing spark context") {
    val list = List(1,2,3,4,5)
    val rdd = sc.parallelize(list)

    assert(rdd.count == list.length)
  }

  test("test generating Datasets[String]") {
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val property =
      forAll(DatasetGenerator.genDataset[String](sqlContext)(Arbitrary.arbitrary[String])) {
        dataset => dataset.map(_.length).count() == dataset.count()
      }

    check(property)
  }
}
