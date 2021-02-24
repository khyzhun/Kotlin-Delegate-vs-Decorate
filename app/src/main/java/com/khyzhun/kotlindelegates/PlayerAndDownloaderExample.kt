package com.khyzhun.kotlindelegates

interface Downloader {
	fun download()
}
interface Player {
	fun play()
}

class FileDownloader(private val file: String): Downloader {
	override fun download() {
		println("FileDownloader | $file Downloader")
	}
}
class FilePlayer(private val file: String): Player {
	override fun play() {
		println("FilePlayer | $file Player")
	}
}

class MediaFile(
	private val downloader: Downloader,
	private val player: Player
) : Downloader by downloader, // delegate
	Player // decorate
{
	override fun play() {
		player.play()
	}
}

fun main() {
	val file = "File1.mkv"
	val mediaFile = MediaFile(
		downloader = FileDownloader(file),
		player = FilePlayer(file)
	)
	mediaFile.download()
	mediaFile.play()
}