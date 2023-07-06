package tech.niklas.ariesbackend.model.types

enum class DatabaseType(val databaseType: String) {
    POSTGRESQL("postgres"),
    MARIADB("mariadb")
}