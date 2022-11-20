package br.com.fabianospdev.bookslist.model.book

import br.com.fabianospdev.bookslist.model.book.access.AccessInfo
import br.com.fabianospdev.bookslist.model.book.sale.SaleInfo
import br.com.fabianospdev.bookslist.model.book.search.SearchInfo
import br.com.fabianospdev.bookslist.model.book.volume.VolumeInfo
import com.google.gson.annotations.SerializedName
import java.util.*

/* Main Object Book */
data class Book(
    @SerializedName("kind")
    var kind: String?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("etag")
    var etag: String?,
    @SerializedName("selfLink")
    var selfLink: String?,
    @SerializedName("volumeInfo")
    var volumeInfo: VolumeInfo?,
    @SerializedName("saleInfo")
    var saleInfo: SaleInfo?,
    @SerializedName("accessInfo")
    var accessInfo: AccessInfo?,
    @SerializedName("searchInfo")
    var searchInfo: SearchInfo?
)


// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json      = Json(JsonConfiguration.Stable)
// val recording = json.parse(Recording.serializer(), jsonString)

// data class Recording(
// @SerializedName("kind")
// val kind: String,
// @SerializedName("")
// val totalItems: Long,
// @SerializedName("")
// val items: List<Item>
// )
//
//
// data class Item(
// @SerializedName("")
// val kind: Kind,
// @SerializedName("")
// val id: String,
// @SerializedName("")
// val etag: String,
// @SerializedName("")
// val selfLink: String,
// @SerializedName("")
// val volumeInfo: VolumeInfo,
// @SerializedName("")
// val saleInfo: SaleInfo,
// @SerializedName("")
// val accessInfo: AccessInfo,
// @SerializedName("")
// val searchInfo: SearchInfo
// )
//
//
// data class AccessInfo(
// @SerializedName("")
// val country: Country,
// @SerializedName("")
// val viewability: Viewability,
// @SerializedName("")
// val embeddable: Boolean,
// @SerializedName("")
// val publicDomain: Boolean,
// @SerializedName("")
// val textToSpeechPermission: TextToSpeechPermission,
// @SerializedName("")
// val epub: Epub,
// @SerializedName("")
// val pdf: Epub,
// @SerializedName("")
// val webReaderLink: String,
// @SerializedName("")
// val accessViewStatus: AccessViewStatus,
// @SerializedName("")
// val quoteSharingAllowed: Boolean
// )
//
//
// enum class AccessViewStatus(val value: String) {
// FullPublicDomain("FULL_PUBLIC_DOMAIN"),
// None("NONE"),
// Sample("SAMPLE");
//
// companion object : KSerializer<AccessViewStatus> {
// override val descriptor: SerialDescriptor
// get() {
// return PrimitiveSerialDescriptor("quicktype.AccessViewStatus", PrimitiveKind.STRING)
// }
//
// override fun deserialize(decoder: Decoder): AccessViewStatus = when (val value = decoder.decodeString()) {
// "FULL_PUBLIC_DOMAIN" -> FullPublicDomain
// "NONE" -> None
// "SAMPLE" -> Sample
// else -> throw IllegalArgumentException("AccessViewStatus could not parse: $value")
// }
//
// override fun serialize(encoder: Encoder, value: AccessViewStatus) {
// return encoder.encodeString(value.value)
// }
// }
// }
//
//
// enum class Country(val value: String) {
// Br("BR");
//
// companion object : KSerializer<Country> {
// override val descriptor: SerialDescriptor
// get() {
// return PrimitiveSerialDescriptor("quicktype.Country", PrimitiveKind.STRING)
// }
//
// override fun deserialize(decoder: Decoder): Country = when (val value = decoder.decodeString()) {
// "BR" -> Br
// else -> throw IllegalArgumentException("Country could not parse: $value")
// }
//
// override fun serialize(encoder: Encoder, value: Country) {
// return encoder.encodeString(value.value)
// }
// }
// }
//
//
// data class Epub(
// @SerializedName("")
// val isAvailable: Boolean,
// @SerializedName("")
// val acsTokenLink: String? = null,
// @SerializedName("")
// val downloadLink: String? = null
// )
//
//
// enum class TextToSpeechPermission(val value: String) {
// Allowed("ALLOWED");
//
// companion object : KSerializer<TextToSpeechPermission> {
// override val descriptor: SerialDescriptor
// get() {
// return PrimitiveSerialDescriptor("quicktype.TextToSpeechPermission", PrimitiveKind.STRING)
// }
//
// override fun deserialize(decoder: Decoder): TextToSpeechPermission = when (val value = decoder.decodeString()) {
// "ALLOWED" -> Allowed
// else -> throw IllegalArgumentException("TextToSpeechPermission could not parse: $value")
// }
//
// override fun serialize(encoder: Encoder, value: TextToSpeechPermission) {
// return encoder.encodeString(value.value)
// }
// }
// }
//
//
// enum class Viewability(val value: String) {
// AllPages("ALL_PAGES"),
// NoPages("NO_PAGES"),
// Partial("PARTIAL");
//
// companion object : KSerializer<Viewability> {
// override val descriptor: SerialDescriptor
// get() {
// return PrimitiveSerialDescriptor("quicktype.Viewability", PrimitiveKind.STRING)
// }
//
// override fun deserialize(decoder: Decoder): Viewability = when (val value = decoder.decodeString()) {
// "ALL_PAGES" -> AllPages
// "NO_PAGES" -> NoPages
// "PARTIAL" -> Partial
// else -> throw IllegalArgumentException("Viewability could not parse: $value")
// }
//
// override fun serialize(encoder: Encoder, value: Viewability) {
// return encoder.encodeString(value.value)
// }
// }
// }
//
//
// enum class Kind(val value: String) {
// BooksVolume("books#volume");
//
// companion object : KSerializer<Kind> {
// override val descriptor: SerialDescriptor
// get() {
// return PrimitiveSerialDescriptor("quicktype.Kind", PrimitiveKind.STRING)
// }
//
// override fun deserialize(decoder: Decoder): Kind = when (val value = decoder.decodeString()) {
// "books#volume" -> BooksVolume
// else -> throw IllegalArgumentException("Kind could not parse: $value")
// }
//
// override fun serialize(encoder: Encoder, value: Kind) {
// return encoder.encodeString(value.value)
// }
// }
// }
//
//
// data class SaleInfo(
// @SerializedName("")
// val country: Country,
// @SerializedName("")
// val saleability: Saleability,
// @SerializedName("")
// val isEbook: Boolean,
// @SerializedName("")
// val listPrice: SaleInfoListPrice? = null,
// @SerializedName("")
// val retailPrice: SaleInfoListPrice? = null,
// @SerializedName("")
// val buyLink: String? = null,
// @SerializedName("")
// val offers: List<Offer>? = null
// )
//
//
// data class SaleInfoListPrice(
// @SerializedName("")
// val amount: Double,
// @SerializedName("")
// val currencyCode: String
// )
//
//
// data class Offer(
// @SerializedName("")
// val finskyOfferType: Long,
// @SerializedName("")
// val listPrice: OfferListPrice,
// @SerializedName("")
// val retailPrice: OfferListPrice,
// @SerializedName("")
// val giftable: Boolean
// )
//
//
// data class OfferListPrice(
// @SerializedName("")
// val amountInMicros: Long,
// @SerializedName("")
// val currencyCode: String
// )
//
//
// enum class Saleability(val value: String) {
// ForSale("FOR_SALE"),
// Free("FREE"),
// NotForSale("NOT_FOR_SALE");
//
// companion object : KSerializer<Saleability> {
// override val descriptor: SerialDescriptor
// get() {
// return PrimitiveSerialDescriptor("quicktype.Saleability", PrimitiveKind.STRING)
// }
//
// override fun deserialize(decoder: Decoder): Saleability = when (val value = decoder.decodeString()) {
// "FOR_SALE" -> ForSale
// "FREE" -> Free
// "NOT_FOR_SALE" -> NotForSale
// else -> throw IllegalArgumentException("Saleability could not parse: $value")
// }
//
// override fun serialize(encoder: Encoder, value: Saleability) {
// return encoder.encodeString(value.value)
// }
// }
// }
//
//
// data class SearchInfo(
// @SerializedName("")
// val textSnippet: String
// )
//
//
// data class VolumeInfo(
// @SerializedName("")
// val title: String,
// @SerializedName("")
// val authors: List<String>? = null,
// @SerializedName("")
// val publisher: String? = null,
// @SerializedName("")
// val publishedDate: String? = null,
// @SerializedName("")
// val description: String? = null,
// @SerializedName("")
// val industryIdentifiers: List<IndustryIdentifier>? = null,
// @SerializedName("")
// val readingModes: ReadingModes,
// @SerializedName("")
// val pageCount: Long? = null,
// @SerializedName("")
// val printType: PrintType,
// @SerializedName("")
// val categories: List<String>? = null,
// @SerializedName("")
// val maturityRating: MaturityRating,
// @SerializedName("")
// val allowAnonLogging: Boolean,
// @SerializedName("")
// val contentVersion: String,
// @SerializedName("")
// val panelizationSummary: PanelizationSummary,
// @SerializedName("")
// val imageLinks: ImageLinks,
// @SerializedName("")
// val language: Language,
// @SerializedName("")
// val previewLink: String,
// @SerializedName("")
// val infoLink: String,
// @SerializedName("")
// val canonicalVolumeLink: String,
// @SerializedName("")
// val subtitle: String? = null,
// @SerializedName("")
// val averageRating: Long? = null,
// @SerializedName("")
// val ratingsCount: Long? = null
// )
//
//
// data class ImageLinks(
// @SerializedName("")
// val smallThumbnail: String,
// @SerializedName("")
// val thumbnail: String
// )
//
//
// data class IndustryIdentifier(
// @SerializedName("")
// val type: Type,
// @SerializedName("")
// val identifier: String
// )
//
//
// enum class Type(val value: String) {
// Isbn10("ISBN_10"),
// Isbn13("ISBN_13"),
// Other("OTHER");
//
// companion object : KSerializer<Type> {
// override val descriptor: SerialDescriptor
// get() {
// return PrimitiveSerialDescriptor("quicktype.Type", PrimitiveKind.STRING)
// }
//
// override fun deserialize(decoder: Decoder): Type = when (val value = decoder.decodeString()) {
// "ISBN_10" -> Isbn10
// "ISBN_13" -> Isbn13
// "OTHER" -> Other
// else -> throw IllegalArgumentException("Type could not parse: $value")
// }
//
// override fun serialize(encoder: Encoder, value: Type) {
// return encoder.encodeString(value.value)
// }
// }
// }
//
//
// enum class Language(val value: String) {
// En("en");
//
// companion object : KSerializer<Language> {
// override val descriptor: SerialDescriptor
// get() {
// return PrimitiveSerialDescriptor("quicktype.Language", PrimitiveKind.STRING)
// }
//
// override fun deserialize(decoder: Decoder): Language = when (val value = decoder.decodeString()) {
// "en" -> En
// else -> throw IllegalArgumentException("Language could not parse: $value")
// }
//
// override fun serialize(encoder: Encoder, value: Language) {
// return encoder.encodeString(value.value)
// }
// }
// }
//
//
// enum class MaturityRating(val value: String) {
// NotMature("NOT_MATURE");
//
// companion object : KSerializer<MaturityRating> {
// override val descriptor: SerialDescriptor
// get() {
// return PrimitiveSerialDescriptor("quicktype.MaturityRating", PrimitiveKind.STRING)
// }
//
// override fun deserialize(decoder: Decoder): MaturityRating = when (val value = decoder.decodeString()) {
// "NOT_MATURE" -> NotMature
// else -> throw IllegalArgumentException("MaturityRating could not parse: $value")
// }
//
// override fun serialize(encoder: Encoder, value: MaturityRating) {
// return encoder.encodeString(value.value)
// }
// }
// }
//
//
// data class PanelizationSummary(
// @SerializedName("")
// val containsEpubBubbles: Boolean,
// @SerializedName("")
// val containsImageBubbles: Boolean
// )
//
//
// enum class PrintType(val value: String) {
// Book("BOOK");
//
// companion object : KSerializer<PrintType> {
// override val descriptor: SerialDescriptor
// get() {
// return PrimitiveSerialDescriptor("quicktype.PrintType", PrimitiveKind.STRING)
// }
//
// override fun deserialize(decoder: Base64.Decoder): PrintType = when (val value = decoder.decodeString()) {
// "BOOK" -> Book
// else -> throw IllegalArgumentException("PrintType could not parse: $value")
// }
//
// override fun serialize(encoder: Base64.Encoder, value: PrintType) {
// return encoder.encodeString(value.value)
// }
// }
// }
//
//
// data class ReadingModes(
// @SerializedName("")
// val text: Boolean,
// @SerializedName("")
// val image: Boolean
// )