<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/apiInfoList/apiInfo">
    <xsl:apply-templates select="."/>
  </xsl:template>
  <xsl:template name="ApiMethodInfo" match="/apiInfoList/apiInfo">
    <xsl:variable name="methodName" select="methodName"/>
    <xsl:variable name="parameterList">
      <xsl:for-each select="parameterInfos/parameterInfo">
        <xsl:call-template name="RequiredParameter"><xsl:with-param name="methodName" select="$methodName"/></xsl:call-template>
      </xsl:for-each>
    </xsl:variable>package net.pocrd.client.apiRequest;

import java.io.InputStream;

import net.pocrd.client.BaseRequest;
import net.pocrd.client.SecurityType;
import net.pocrd.client.apiEntity.<xsl:call-template name="getEntityName"><xsl:with-param name="name" select="returnType"/></xsl:call-template>;

/**
 * <xsl:value-of select="description"/>
 * @author org.pocrd.ClientCodeGenerator
 *
 */
public class <xsl:call-template name="string-replace-all">
               <xsl:with-param name="text" select="methodName" />
               <xsl:with-param name="replace" select="'.'" />
               <xsl:with-param name="by" select="'_'" />
             </xsl:call-template> extends BaseRequest<xsl:text disable-output-escaping="yes"><![CDATA[<]]></xsl:text><xsl:call-template name="getLastName"><xsl:with-param name="name" select="returnType"/></xsl:call-template><xsl:text disable-output-escaping="yes"><![CDATA[>]]></xsl:text> {
    /**
     * 当前请求的构造函数，以下参数为必填参数<xsl:for-each select="parameterInfos/parameterInfo"><xsl:call-template name="RequiredParameterComment"><xsl:with-param name="methodName" select="$methodName"/></xsl:call-template></xsl:for-each>
     */
    public <xsl:call-template name="string-replace-all">
             <xsl:with-param name="text" select="methodName" />
             <xsl:with-param name="replace" select="'.'" />
             <xsl:with-param name="by" select="'_'" />
           </xsl:call-template>(<xsl:choose><xsl:when test="contains($parameterList, ', ')"><xsl:value-of select="substring($parameterList,0,string-length($parameterList)-1)"/>
             </xsl:when>
           </xsl:choose>) {
        super("<xsl:value-of select="translate(methodName,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')"></xsl:value-of>", SecurityType.<xsl:value-of select="securityLevel"></xsl:value-of>, null, false);
        <xsl:for-each select="parameterInfos/parameterInfo"><xsl:call-template name="RequiredParameterSetter"><xsl:with-param name="methodName" select="$methodName"/></xsl:call-template></xsl:for-each>
    }
    <xsl:for-each select="parameterInfos/parameterInfo"><xsl:call-template name="NotRequiredParameterSetter"/></xsl:for-each>
    /**
     * 当前请求有可能的异常返回值
     */
    public int handleError() {
        switch (response.code) {<xsl:for-each select="errorCodes/apiCode"><xsl:call-template name="ErrorCode"/></xsl:for-each>
        }
        return response.code;
    }
    
    @Override
    protected <xsl:call-template name="getLastName"><xsl:with-param name="name" select="returnType"/></xsl:call-template> getResult(InputStream stream) {<xsl:text disable-output-escaping="yes">
        if (response.length <![CDATA[>]]> 0) {</xsl:text>
            try {
                return <xsl:call-template name="getLastName"><xsl:with-param name="name" select="returnType"/></xsl:call-template>.parseFrom(stream);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
  </xsl:template>
  <xsl:template name ="getEntityName">
    <xsl:param name="name"></xsl:param>
    <xsl:variable name="subname">
      <xsl:call-template name="getLastName">
        <xsl:with-param name="name" select="$name"/>
      </xsl:call-template>
    </xsl:variable>
    <xsl:call-template name="string-replace-all">
      <xsl:with-param name="text" select="$subname" />
      <xsl:with-param name="replace" select="'_'" />
      <xsl:with-param name="by" select="''" />
    </xsl:call-template>.<xsl:value-of select="$subname"/>
  </xsl:template>
  <xsl:template name ="getLastName">
    <xsl:param name="name"/>
    <xsl:choose>
      <xsl:when test="contains($name, '.')">
        <xsl:call-template name="getLastName">
          <xsl:with-param name="name" select="substring-after($name, '.')"/>
        </xsl:call-template>
      </xsl:when>
      <xsl:otherwise>
        <xsl:value-of select="$name"/>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  <xsl:template name="string-replace-all">
    <xsl:param name="text" />
    <xsl:param name="replace" />
    <xsl:param name="by" />
    <xsl:choose>
      <xsl:when test="contains($text, $replace)">
        <xsl:value-of select="substring-before($text,$replace)" />
        <xsl:value-of select="$by" />
        <xsl:call-template name="string-replace-all">
          <xsl:with-param name="text" select="substring-after($text,$replace)" />
          <xsl:with-param name="replace" select="$replace" />
          <xsl:with-param name="by" select="$by" />
        </xsl:call-template>
      </xsl:when>
      <xsl:otherwise>
        <xsl:value-of select="$text" />
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  <xsl:template name="RequiredParameterComment">
    <xsl:param name="methodName"/>
    <xsl:if test="isRequired = 'true'">
      <xsl:if test="$methodName = 'Device.Regist' or (name != 'sn' and name != 'deviceType' and name != 'appid' and name != 'eKeyPwd')">
      * @param <xsl:value-of select="name"/><xsl:value-of select="' '"/><xsl:value-of select="description"/></xsl:if></xsl:if>
  </xsl:template>
  <xsl:template name="RequiredParameter">
    <xsl:param name="methodName"/>
    <xsl:if test="isRequired = 'true'">
      <xsl:if test="$methodName = 'Device.Regist' or (name != 'sn' and name != 'deviceType' and name != 'appid' and name != 'eKeyPwd')">
      <xsl:call-template name="ParseType">
        <xsl:with-param name="type">
          <xsl:call-template name="getLastName">
            <xsl:with-param name="name" select="type"/>
          </xsl:call-template>
        </xsl:with-param>
      </xsl:call-template>
      <xsl:value-of select="' '"/>
      <xsl:value-of select="name"/>
      <xsl:value-of select="', '"/>
    </xsl:if>
    </xsl:if>
  </xsl:template>
  <xsl:template name="ParseType">
    <xsl:param name="type"/>
    <xsl:choose>
      <xsl:when test="$type = 'Int32'">int</xsl:when>
      <xsl:when test="$type = 'Int64'">long</xsl:when>
      <xsl:when test="$type = 'Boolean'">boolean</xsl:when>
      <xsl:otherwise><xsl:value-of select="$type"/></xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  <xsl:template name="ParseValue">
    <xsl:param name="type"/>
    <xsl:param name="value"/>
    <xsl:choose>
      <xsl:when test="$type = 'int'">String.valueOf(<xsl:value-of select="$value"/>)</xsl:when>
      <xsl:when test="$type = 'long'">String.valueOf(<xsl:value-of select="$value"/>)</xsl:when>
      <xsl:otherwise>
        <xsl:value-of select="$value"/>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  <xsl:template name="RequiredParameterSetter">
    <xsl:param name="methodName"/>
    <xsl:if test="IsRequired = 'true'"><xsl:if test="$methodName = 'Device.Regist' or (name != 'sn' and name != 'deviceType' and name != 'appid' and name != 'eKeyPwd')">
        params.put("<xsl:value-of select="translate(name,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')"/>", <xsl:call-template name="ParseValue">
      <xsl:with-param name="type">
        <xsl:call-template name="getLastName">
          <xsl:with-param name="name" select="type"/>
        </xsl:call-template>
      </xsl:with-param>
      <xsl:with-param name="value" select="name"/></xsl:call-template>);</xsl:if>
      <xsl:if test="not ($methodName = 'Device.Regist' or (name != 'sn' and name != 'deviceType' and name != 'appid' and name != 'eKeyPwd'))">
        this.<xsl:value-of select="name"/>Required = true;</xsl:if>
    </xsl:if>
  </xsl:template>
  <xsl:template name="NotRequiredParameterSetter">
    <xsl:if test="IsRequired = 'false'">
      <xsl:variable name="name" select="name"/>
      <xsl:variable name="first" select="substring(name, 1, 1)"/>
      <xsl:variable name="firstUpper" select="translate($first,'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ')"/>
      <xsl:variable name="lowerName" select="translate(name,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')"/>
    /**
     * 当前请求的非必填参数
     * @param <xsl:value-of select="name"/><xsl:value-of select="' '"/><xsl:value-of select="description"/>
     */
    public void set<xsl:value-of select="$firstUpper"/><xsl:value-of select="substring(name, 2)"/>(<xsl:call-template name="ParseType">
      <xsl:with-param name="type">
        <xsl:call-template name="getLastName">
          <xsl:with-param name="name" select="type"/>
        </xsl:call-template>
      </xsl:with-param>
    </xsl:call-template><xsl:value-of select="' '"/><xsl:value-of select="$name"/>) {
        params.put("<xsl:value-of select="$lowerName"/>", <xsl:call-template name="ParseValue">
          <xsl:with-param name="type">
            <xsl:call-template name="getLastName">
              <xsl:with-param name="name" select="type"/>
            </xsl:call-template>
          </xsl:with-param>
          <xsl:with-param name="value" select="$name"/>
        </xsl:call-template>);
    }
    </xsl:if>
  </xsl:template>
  <xsl:template name="ErrorCode">
            case ApiCode.<xsl:value-of select="."/>: {
                break;
            }</xsl:template>
  <xsl:template name="ApiCode" match="/ApiMethods/ApiCode">package com.yuncheng.api.request;

/**
 * 本类定义了接口有可能的返回值集合
 */
public class ApiCode {
    <xsl:for-each select="Code">
    /** <xsl:value-of select="Message"/> */
    public static final int <xsl:value-of select="Name"/> = <xsl:value-of select="Value"/>;
    </xsl:for-each>
}</xsl:template>
</xsl:stylesheet>
