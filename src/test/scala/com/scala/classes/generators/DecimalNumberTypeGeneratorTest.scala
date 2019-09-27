/*
 * Created 2019 by Dylan Kessler
 */

package com.scala.classes.generators

import java.util.Properties

import com.scala.classes.posos.GenericRecordsTemplate
import com.scala.classes.utilities.PropertyLoader
import com.scala.classes.validators.ExcelSheetValidatorTestMocks
import org.junit.Assert.assertNotNull
import org.junit.{Before, Test}

import scala.collection.mutable.ArrayBuffer

/**
  *
  */
@Test
class DecimalNumberTypeGeneratorTest {

  var properties:Properties = _
  var template:GenericRecordsTemplate = _

  /**
    * initialization
    */
  @Before
  def initialize():Unit = {
    properties = PropertyLoader.getProperties("C:\\home\\schnarbies\\config\\config.properties")
    var mocks:ExcelSheetValidatorTestMocks = new ExcelSheetValidatorTestMocks(properties)
    template = mocks.getBlankTemplate()

  }

  /**
    * Junit tests for the EnumFloat and EnumDouble data types
    */
  @Test
  def makeEnumDecimalNumberTest():Unit = {
    // simple test
    template.dataQualifiers = Array(ArrayBuffer("1","2","3"))
    var results:String = DecimalNumberTypeGenerator.makeEnumDecimalNumber(template.dataQualifiers(0))
    assertNotNull(results)
    println(results)
    for(i <- 0 until 10) {
      println(DecimalNumberTypeGenerator.makeEnumDecimalNumber(template.dataQualifiers(0)))
    }
  }

  /**
    * Junit tests for the RandomFloat and RandomDouble data types
    */
  @Test
  def makeRandomDecimalNumberTest():Unit = {
    // test with length and min and max
    template.dataFormats = Array("length,min,max")
    template.dataQualifiers(0) = ArrayBuffer("10","10","100")
    var results:String = DecimalNumberTypeGenerator.makeRandomDecimalNumber(template.dataFormats(0),template.dataQualifiers(0))
    assertNotNull(results)
    for(i <- 0 until 10) {
      println(DecimalNumberTypeGenerator.makeRandomDecimalNumber(template.dataFormats(0),template.dataQualifiers(0)))
    }
    // test significant digits
    template.dataFormats = Array("length,min,max,signDigits")
    template.dataQualifiers(0) = ArrayBuffer("10","10","1000000","2")
    results = DecimalNumberTypeGenerator.makeRandomDecimalNumber(template.dataFormats(0),template.dataQualifiers(0))
    for(i <- 0 until 10) {
      println(DecimalNumberTypeGenerator.makeRandomDecimalNumber(template.dataFormats(0),template.dataQualifiers(0)))
    }
    // test negatives
    template.dataFormats = Array("length,min,max,signDigits")
    template.dataQualifiers(0) = ArrayBuffer("10","-10000","0","2")
    results = DecimalNumberTypeGenerator.makeRandomDecimalNumber(template.dataFormats(0),template.dataQualifiers(0))
    for(i <- 0 until 10) {
      println(DecimalNumberTypeGenerator.makeRandomDecimalNumber(template.dataFormats(0),template.dataQualifiers(0)))
    }
    // test rounding
    template.dataFormats = Array("length,min,max,signDigits,rounddown")
    template.dataQualifiers(0) = ArrayBuffer("10","10","1000000","15")
    results = DecimalNumberTypeGenerator.makeRandomDecimalNumber(template.dataFormats(0),template.dataQualifiers(0))
    for(i <- 0 until 10) {
      println(DecimalNumberTypeGenerator.makeRandomDecimalNumber(template.dataFormats(0),template.dataQualifiers(0)))
    }
    // test negatives and positives, with no padding
    template.dataFormats = Array("min,max,signDigits,rounddown")
    template.dataQualifiers(0) = ArrayBuffer("-10","10","15")
    results = DecimalNumberTypeGenerator.makeRandomDecimalNumber(template.dataFormats(0),template.dataQualifiers(0))
    for(i <- 0 until 10) {
      println(DecimalNumberTypeGenerator.makeRandomDecimalNumber(template.dataFormats(0),template.dataQualifiers(0)))
    }
    // test negatives and positives, with no padding
    template.dataFormats = Array("min,max,signDigits,rounddown")
    template.dataQualifiers(0) = ArrayBuffer("-10","10","2")
    results = DecimalNumberTypeGenerator.makeRandomDecimalNumber(template.dataFormats(0),template.dataQualifiers(0))
    for(i <- 0 until 10) {
      println(DecimalNumberTypeGenerator.makeRandomDecimalNumber(template.dataFormats(0),template.dataQualifiers(0)))
    }
    // test negatives and positives, with padding
    template.dataFormats = Array("length,min,max,signDigits,rounddown")
    template.dataQualifiers(0) = ArrayBuffer("6","-10","10","2")
    results = DecimalNumberTypeGenerator.makeRandomDecimalNumber(template.dataFormats(0),template.dataQualifiers(0))
    for(i <- 0 until 10) {
      println(DecimalNumberTypeGenerator.makeRandomDecimalNumber(template.dataFormats(0),template.dataQualifiers(0)))
    }
  }

  /**
    * Junit tests for the ExternalFloat and ExternalDouble data types
    */
  @Test
  def makeExternalDecimalNumberTest():Unit = {
    // simple test
    template.dataQualifiers = Array(ArrayBuffer("1","2","3"))
    var results:String = DecimalNumberTypeGenerator.makeExternalDecimalNumber(template.dataQualifiers(0))
    assertNotNull(results)
    println(results)
    for(i <- 0 until 10) {
      println(DecimalNumberTypeGenerator.makeExternalDecimalNumber(template.dataQualifiers(0)))
    }
  }
}
