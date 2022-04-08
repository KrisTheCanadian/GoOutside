// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package me.kristhecanadian.gooutside.ar

import android.content.Context
import android.net.Uri
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.ar.core.Anchor
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.Node
import com.google.ar.sceneform.assets.RenderableSource
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.rendering.Renderable
import com.google.ar.sceneform.rendering.ViewRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode
import com.google.codelabs.goOutside.R
import me.kristhecanadian.gooutside.model.Place


class PlaceNode(
    val context: Context,
    val place: Place?
) : Node() {

    private var placeRenderable: ViewRenderable? = null
    private var textViewPlace: TextView? = null

    override fun onActivate() {
        super.onActivate()

        if (scene == null) {
            return
        }

        if (placeRenderable != null) {
            return
        }
        mock_database_prototyping()
    }

    private fun mock_database_prototyping() {
        // We are mocking the database because we do not have any users.
        // Usually we would store this on firebase and retrieve them dynamically
        // For demo/ui purposes we will simplify this process by creating static views
        // which have art pieces
        val renders = arrayOf(
            R.layout.place_view,
            R.layout.place_view1,
            R.layout.place_view2,
            R.layout.place_view3,
            R.layout.place_view4,
            R.layout.place_view5,
            R.layout.place_view6,
            R.layout.place_view7,
            R.layout.place_view8,
            R.layout.place_view9,
            R.layout.place_view10,
            R.layout.place_view11,
            R.layout.place_view12,
            R.layout.place_view13,
            R.layout.place_view14,
            R.layout.place_view15
        )
        ViewRenderable.builder()
            .setView(context, renders[(renders.indices).random()])
            .build()
            .thenAccept { renderable ->
                setRenderable(renderable)
                placeRenderable = renderable

                place?.let {
                    textViewPlace = renderable.view.findViewById(R.id.placeName)
                    textViewPlace?.text = it.name
                }
            }
    }

    fun showInfoWindow() {
        // Show text
        textViewPlace?.let {
            it.visibility = if (it.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        }

        // Hide text for other nodes
        this.parent?.children?.filter {
            it is PlaceNode && it != this
        }?.forEach {
            (it as PlaceNode).textViewPlace?.visibility = View.GONE
        }
    }

}