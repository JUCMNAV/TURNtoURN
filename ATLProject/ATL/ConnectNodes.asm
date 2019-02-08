<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="ConnectNodes"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="__exec__"/>
		<constant value="connectNodes"/>
		<constant value="3"/>
		<constant value="4"/>
		<constant value="nodeCounter"/>
		<constant value="pathNodes"/>
		<constant value="5"/>
		<constant value="J.=(J):J"/>
		<constant value="14"/>
		<constant value="Path"/>
		<constant value="Turn"/>
		<constant value="J.oclIsTypeOf(J):J"/>
		<constant value="29"/>
		<constant value="OrFork"/>
		<constant value="27"/>
		<constant value="28"/>
		<constant value="J.inc():J"/>
		<constant value="7:3-7:13"/>
		<constant value="7:29-7:30"/>
		<constant value="7:3-7:31"/>
		<constant value="8:16-8:24"/>
		<constant value="8:16-8:34"/>
		<constant value="9:7-9:17"/>
		<constant value="9:7-9:29"/>
		<constant value="9:32-9:33"/>
		<constant value="9:7-9:33"/>
		<constant value="41:5-41:9"/>
		<constant value="41:5-41:10"/>
		<constant value="10:8-10:12"/>
		<constant value="10:25-10:34"/>
		<constant value="10:8-10:35"/>
		<constant value="13:13-13:17"/>
		<constant value="13:30-13:41"/>
		<constant value="13:13-13:42"/>
		<constant value="14:6-14:10"/>
		<constant value="14:6-14:11"/>
		<constant value="13:10-15:6"/>
		<constant value="11:6-11:10"/>
		<constant value="11:6-11:11"/>
		<constant value="10:5-15:6"/>
		<constant value="9:4-42:5"/>
		<constant value="43:4-43:14"/>
		<constant value="43:30-43:40"/>
		<constant value="43:30-43:52"/>
		<constant value="43:30-43:58"/>
		<constant value="43:4-43:59"/>
		<constant value="8:3-44:4"/>
		<constant value="6:2-45:3"/>
		<constant value="node"/>
		<constant value="pathbody"/>
		<constant value="path"/>
		<constant value="tUCMmap"/>
		<constant value="nextNode"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<pcall arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<pcall arg="10"/>
			<pcall arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="15"/>
			<getasm/>
			<pcall arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="-1"/>
		</localvariabletable>
	</operation>
	<operation name="40">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="-1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="4"/>
			<parameter name="42" type="4"/>
			<parameter name="43" type="4"/>
		</parameters>
		<code>
			<getasm/>
			<pushi arg="19"/>
			<set arg="44"/>
			<load arg="19"/>
			<get arg="45"/>
			<iterate/>
			<store arg="46"/>
			<getasm/>
			<get arg="44"/>
			<pushi arg="19"/>
			<call arg="47"/>
			<if arg="48"/>
			<load arg="46"/>
			<goto arg="27"/>
			<load arg="29"/>
			<push arg="49"/>
			<push arg="50"/>
			<findme/>
			<call arg="51"/>
			<if arg="52"/>
			<load arg="29"/>
			<push arg="53"/>
			<push arg="50"/>
			<findme/>
			<call arg="51"/>
			<if arg="54"/>
			<goto arg="55"/>
			<load arg="46"/>
			<goto arg="27"/>
			<load arg="46"/>
			<getasm/>
			<getasm/>
			<get arg="44"/>
			<call arg="56"/>
			<set arg="44"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="57" begin="0" end="0"/>
			<lne id="58" begin="1" end="1"/>
			<lne id="59" begin="0" end="2"/>
			<lne id="60" begin="3" end="3"/>
			<lne id="61" begin="3" end="4"/>
			<lne id="62" begin="7" end="7"/>
			<lne id="63" begin="7" end="8"/>
			<lne id="64" begin="9" end="9"/>
			<lne id="65" begin="7" end="10"/>
			<lne id="66" begin="12" end="12"/>
			<lne id="67" begin="12" end="12"/>
			<lne id="68" begin="14" end="14"/>
			<lne id="69" begin="15" end="17"/>
			<lne id="70" begin="14" end="18"/>
			<lne id="71" begin="20" end="20"/>
			<lne id="72" begin="21" end="23"/>
			<lne id="73" begin="20" end="24"/>
			<lne id="74" begin="27" end="27"/>
			<lne id="75" begin="27" end="27"/>
			<lne id="76" begin="20" end="27"/>
			<lne id="77" begin="29" end="29"/>
			<lne id="78" begin="29" end="29"/>
			<lne id="79" begin="14" end="29"/>
			<lne id="80" begin="7" end="29"/>
			<lne id="81" begin="30" end="30"/>
			<lne id="82" begin="31" end="31"/>
			<lne id="83" begin="31" end="32"/>
			<lne id="84" begin="31" end="33"/>
			<lne id="85" begin="30" end="34"/>
			<lne id="86" begin="3" end="35"/>
			<lne id="87" begin="0" end="35"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="5" name="88" begin="6" end="34"/>
			<lve slot="0" name="17" begin="0" end="35"/>
			<lve slot="1" name="89" begin="0" end="35"/>
			<lve slot="2" name="90" begin="0" end="35"/>
			<lve slot="3" name="91" begin="0" end="35"/>
			<lve slot="4" name="92" begin="0" end="35"/>
		</localvariabletable>
	</operation>
</asm>
