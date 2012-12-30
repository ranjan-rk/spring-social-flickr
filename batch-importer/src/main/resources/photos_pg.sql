
--
--

-- photo albums from flickr, or 'photosets'
CREATE TABLE photo_albums (
  id serial NOT NULL primary key ,
  user_id character varying(300) not null,
  count_photos integer not null,
  count_videos integer not null,
  title character varying(300) NOT NULL,
  description character varying(300) NOT NULL,
  album_id character varying(100) NOT NULL unique,
  url character varying(300)  NULL
);


CREATE TABLE photos
(
  id serial NOT NULL,
  album_id character varying(100) NOT NULL,
  photo_id character varying(300) NOT NULL,
  title character varying(300)   null,
  url character varying(300) NOT NULL,
  comments character varying(300),
  CONSTRAINT photos_pkey PRIMARY KEY (id ),
  CONSTRAINT photo_album_fk FOREIGN KEY (album_id)
      REFERENCES photo_albums (album_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT photo_album_photo UNIQUE (album_id , photo_id )
)  ;